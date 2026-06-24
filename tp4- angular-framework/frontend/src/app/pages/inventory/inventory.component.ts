import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { InventoryApiService } from '../../services/inventory-api.service';
import { InventoryItem } from '../../models/inventory-item.model';

@Component({
  selector: 'app-inventory',
  imports: [CommonModule, FormsModule],
  templateUrl: './inventory.component.html',
  styleUrl: './inventory.component.css'
})
export class InventoryComponent implements OnInit {
  products: InventoryItem[] = [];
  selectedId: number | null = null;
  formData: Omit<InventoryItem, 'id'> = {
    name: '',
    price: 0,
    selected: false
  };

  constructor(private inventoryApi: InventoryApiService) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.inventoryApi.getProducts().subscribe(products => {
      this.products = products;
    });
  }

  startCreate(): void {
    this.selectedId = null;
    this.formData = { name: '', price: 0, selected: false };
  }

  startEdit(product: InventoryItem): void {
    if (!product.id) {
      return;
    }
    this.selectedId = product.id;
    this.formData = {
      name: product.name,
      price: product.price,
      selected: product.selected
    };
  }

  saveProduct(): void {
    if (!this.formData.name.trim()) {
      return;
    }

    const payload = {
      name: this.formData.name.trim(),
      price: this.formData.price,
      selected: this.formData.selected
    };

    if (this.selectedId === null) {
      this.inventoryApi.createProduct(payload).subscribe(() => {
        this.startCreate();
        this.loadProducts();
      });
      return;
    }

    this.inventoryApi.updateProduct(this.selectedId, payload).subscribe(() => {
      this.startCreate();
      this.loadProducts();
    });
  }

  toggleSelected(product: InventoryItem): void {
    if (!product.id) {
      return;
    }
    const newValue = !product.selected;
    this.inventoryApi.updateSelected(product.id, newValue).subscribe(updated => {
      product.selected = updated.selected;
    });
  }

  onDelete(product: InventoryItem): void {
    if (!product.id) {
      return;
    }
    const confirmed = confirm(`Êtes-vous sûr de vouloir supprimer "${product.name}" ?`);
    if (!confirmed) {
      return;
    }
    this.inventoryApi.deleteProduct(product.id).subscribe(() => {
      this.products = this.products.filter(p => p.id !== product.id);
    });
  }
}

