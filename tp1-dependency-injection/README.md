# Dependency Injection & Inversion of Control

A Java teaching project demonstrating four approaches to Dependency Injection and Inversion of Control using Spring Framework 6.

## Architecture

```
src/main/java/
├── repositories/          # Data Access Layer
│   ├── IDaoRepository.java
│   ├── IDaoRepositoryImpl.java
├── extensions/            # Alternative implementations
│   └── IDaoRepositoryV2Impl.java
├── services/              # Business Logic Layer
│   ├── IBusinessService.java
│   └── IBusinessServiceImpl.java
└── presentation/          # Client entry points
    ├── StaticInjectionApp.java      # Tight coupling (new keyword)
    ├── DynamicInjectionApp.java     # Reflection + config.txt
    ├── AnnotationBasedApp.java      # Spring annotations
    └── XmlConfigApp.java            # Spring XML config
```

## Approaches Demonstrated

| Approach | File | Mechanism |
|---|---|---|
| **Static / Tight Coupling** | `StaticInjectionApp.java` | Hard-coded `new` |
| **Dynamic / Reflection** | `DynamicInjectionApp.java` | `Class.forName()` + `config.txt` |
| **Spring XML** | `XmlConfigApp.java` + `config.xml` | `ClassPathXmlApplicationContext` |
| **Spring Annotations** | `AnnotationBasedApp.java` | `AnnotationConfigApplicationContext` + component scanning |

## Tech Stack

- Java 17
- Spring Framework 6.1.4 (core, context, beans)
- Maven


