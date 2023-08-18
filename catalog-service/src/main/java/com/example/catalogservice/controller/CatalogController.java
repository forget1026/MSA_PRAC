package com.example.catalogservice.controller;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.mapper.CatalogMapper;
import com.example.catalogservice.service.CatalogService;
import com.example.catalogservice.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {
    private final Environment env;
    private final CatalogService service;
    private final CatalogMapper mapper;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Catalog Service on Port %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs() {
        Iterable<CatalogEntity> catalogEntities = service.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        catalogEntities.forEach(v -> result.add(mapper.toResponseCatalog(v)));

        return ResponseEntity.ok(result);
    }
}
