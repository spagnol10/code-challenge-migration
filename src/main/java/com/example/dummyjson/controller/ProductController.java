package com.example.dummyjson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

        @Autowired
        private ProductService productService;

        @Operation(summary = "Obtém todos os produtos", description = "Retorna uma lista de todos os produtos disponíveis, incluindo título, descrição e preço.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Lista de produtos recuperada com sucesso."),
                        @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
        })
        @GetMapping
        public List<Product> getAllProducts() {
                return productService.getAllProducts();
        }

        @Operation(summary = "Obtém um produto pelo ID", description = "Retorna um produto específico baseado no ID fornecido, incluindo título, descrição e preço.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso."),
                        @ApiResponse(responseCode = "404", description = "Produto não encontrado com o ID fornecido."),
                        @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
        })
        @GetMapping("/{id}")
        public Product getProductById(
                        @Parameter(description = "ID do produto", required = true) @PathVariable @NotNull Long id) {
                return productService.getProductById(id);
        }

        @Operation(summary = "Verificação de saúde do serviço", description = "Verifica se o serviço está em funcionamento, retornando um status simples.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Serviço está funcionando corretamente."),
                        @ApiResponse(responseCode = "500", description = "Erro interno no serviço.")
        })
        @GetMapping("/health")
        public ResponseEntity<String> healthCheck() {
                return ResponseEntity.ok("Service is up and running");
        }
}
