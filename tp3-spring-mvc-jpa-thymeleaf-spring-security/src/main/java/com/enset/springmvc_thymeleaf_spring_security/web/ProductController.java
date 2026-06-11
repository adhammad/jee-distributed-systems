package com.enset.springmvc_thymeleaf_spring_security.web;

import com.enset.springmvc_thymeleaf_spring_security.entities.Product;
import com.enset.springmvc_thymeleaf_spring_security.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    private static final int DEFAULT_PAGE_SIZE = 5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping({"/", "/products"})
    public String listProducts(Model model,
                               @RequestParam(defaultValue = "") String keyword,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size) {
        int safePage = Math.max(page, 0);
        int safeSize = size > 0 ? size : DEFAULT_PAGE_SIZE;
        Pageable pageable = PageRequest.of(safePage, safeSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<Product> productPage = keyword == null || keyword.isBlank()
                ? productRepository.findAll(pageable)
                : productRepository.findByNameContainingIgnoreCase(keyword.trim(), pageable);

        model.addAttribute("productPage", productPage);
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("pages", pageIndexes(productPage));
        model.addAttribute("currentPage", safePage);
        model.addAttribute("keyword", keyword == null ? "" : keyword.trim());
        model.addAttribute("size", safeSize);
        model.addAttribute("totalProducts", productPage.getTotalElements());
        return "products/list";
    }

    @GetMapping("/products/{id}")
    public String productDetails(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return productRepository.findById(id)
                .map(product -> {
                    model.addAttribute("product", product);
                    return "products/details";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Produit introuvable");
                    return "redirect:/products";
                });
    }

    @GetMapping("/admin/products/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("formTitle", "Ajouter un produit");
        model.addAttribute("submitLabel", "Ajouter");
        return "products/form";
    }

    @PostMapping("/admin/products")
    public String createProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formTitle", "Ajouter un produit");
            model.addAttribute("submitLabel", "Ajouter");
            return "products/form";
        }

        productRepository.save(product);
        redirectAttributes.addFlashAttribute("successMessage", "Produit ajouté avec succès");
        return "redirect:/products";
    }

    @GetMapping("/admin/products/{id}/edit")
    public String editProductForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return productRepository.findById(id)
                .map(product -> {
                    model.addAttribute("product", product);
                    model.addAttribute("formTitle", "Modifier un produit");
                    model.addAttribute("submitLabel", "Mettre à jour");
                    return "products/form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Produit introuvable");
                    return "redirect:/products";
                });
    }

    @PostMapping("/admin/products/{id}")
    public String updateProduct(@PathVariable Long id,
                                @Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            product.setId(id);
            model.addAttribute("formTitle", "Modifier un produit");
            model.addAttribute("submitLabel", "Mettre à jour");
            return "products/form";
        }

        if (!productRepository.existsById(id)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Produit introuvable");
            return "redirect:/products";
        }

        product.setId(id);
        productRepository.save(product);
        redirectAttributes.addFlashAttribute("successMessage", "Produit mis à jour avec succès");
        return "redirect:/products";
    }

    @PostMapping("/admin/products/{id}/delete")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Produit supprimé avec succès");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Produit introuvable");
        }
        return "redirect:/products";
    }

    private List<Integer> pageIndexes(Page<Product> productPage) {
        if (productPage.getTotalPages() == 0) {
            return List.of();
        }
        return IntStream.range(0, productPage.getTotalPages()).boxed().toList();
    }
}
