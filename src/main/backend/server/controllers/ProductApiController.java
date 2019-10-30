package server.controllers;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import server.domain.Product;
import server.dto.FiltersList;
import server.services.ProductService;

import java.util.Map;

@Log
@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductApiController {
    private final ProductService productService;

    @GetMapping("/{group}/{page}")
    private Page<Product> listProductsByGroupPage(@PathVariable String group, @PathVariable(required = false) int page) {
        return productService.getProductsByGroup(group, PageRequest.of(page, 15, Sort.Direction.ASC, "pic"));
    }

    @GetMapping("/show/{productID}")
    private Product listProductByID(@PathVariable String productID) {
        return productService.getProductByID(productID);
    }

    @PostMapping("/filter/{group}")
    private Page<Product> filterProducts(@RequestBody Map<String, String[]> filters, @PathVariable String group) {
        return productService.filterProducts(filters, group);
    }

    @GetMapping("/page/filters/{group}")
    private FiltersList createFiltersLists(@PathVariable String group) {
        return productService.createProductsFilterLists(group);
    }
}