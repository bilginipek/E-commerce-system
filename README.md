# 🛒 E-Commerce System (Java) 🛒

![Java](https://img.shields.io/badge/Java-17-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-★-pink?style=for-the-badge)
![Author](https://img.shields.io/badge/Author-Ipek%20Bilgin-pink?style=for-the-badge)
📍 **E-Commerce System** is a **Java console application** simulating a simple e-commerce environment.  
It demonstrates **object-oriented design, abstraction, inheritance, polymorphism, generics, and collections** in a clean and structured way.

---

## 🎯 Features

- **Product Abstraction:**  
  Base `Product` class with specialized subclasses for different product types.  

- **Specialized Products:**  
  - `ElectronicsProduct` (with warranty handling)  
  - `ClothingProduct` (with size and material, including organic discount)  
  - `BookProduct` (with author information)  

- **Inventory Management:**  
  Generic inventory system using `ArrayList` and **filtering by product type**.  

- **Price Calculation:**  
  - Electronics: +5% surcharge for warranty  
  - Clothing: 10% discount for organic materials  
  - Books: base price  

- **Detailed Display:**  
  - Standard view or detailed view  
  - Currency conversion (USD, EUR, GBP)  

- **Filter Products:**  
  Quickly display all electronics, clothing, or books using generic filtering.

---

## 🖥 Example Output

```bash 
DISPLAY INFO
[DETAILED ELECTRONICS] Product ID: E1231 Name: Laptop Base Price: 30000.0 Warranty: 24 months
[DETAILED CLOTHING] Product ID: C1444 Name: T-Shirt Base Price: 800.0 Size: M Material: Organic
[DETAILED BOOK] Product ID: B9090 Name: Çizgili Pijamalı Çocuk Base Price: 1500.0 Author: John Boyne

FINAL PRICES
Laptop Final Price: 31500.0
T-Shirt Final Price: 720.0
Çizgili Pijamalı Çocuk Final Price: 1500.0

TOTAL COST: 33720.0

FILTER: ELECTRONICS ONLY
[DETAILED ELECTRONICS] Product ID: E1231 Name: Laptop Base Price: 30000.0 Warranty: 24 months

FX DISPLAY (USD)
[FX] Product ID: E1231 Name: Laptop TRY Price: 30000.0 | USD Price: 857.14
[FX] Product ID: C1444 Name: T-Shirt TRY Price: 800.0 | USD Price: 22.86
[FX] Product ID: B9090 Name: Çizgili Pijamalı Çocuk TRY Price: 1500.0 | USD Price: 42.86
```
# 🚀 How to Run
```bash
git clone https://github.com/bilginipek/E-commerce-system.git
cd E-commerce-system
javac *.java
java EcommerceSystem
``` 
