package com.upiiz.dep1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.upiiz.dep1.models.Venta;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class VentasRepository {
    private final String archivoJson = "src/main/resources/ventas.json";
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private List<Venta> ventas = new ArrayList<>();

    public VentasRepository() {
        cargarVentas();
    }

    // Leer las ventas del archivo JSON
    private void cargarVentas() {
        try {
            File archivo = new File(archivoJson);
            if (archivo.exists()) {
                ventas = objectMapper.readValue(archivo, new TypeReference<List<Venta>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Guardar las ventas en el archivo JSON
    private void guardarVentas() {
        try {
            objectMapper.writeValue(new File(archivoJson), ventas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Venta> obtenerVentas() {
        return ventas;
    }

    public Optional<Venta> obtenerVenta(Long id) {
        return ventas.stream().filter(venta -> venta.getId().equals(id)).findFirst();
    }

    public Venta guardar(Venta venta) {
        venta.setId(generarNuevoId());
        ventas.add(venta);
        guardarVentas();
        return venta;
    }

    public Venta actualizar(Long id, Venta nuevaVenta) {
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getId().equals(id)) {
                nuevaVenta.setId(id);
                ventas.set(i, nuevaVenta);
                guardarVentas();
                return nuevaVenta;
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        boolean eliminado = ventas.removeIf(venta -> venta.getId().equals(id));
        if (eliminado) {
            guardarVentas();
        }
        return eliminado;
    }

    private Long generarNuevoId() {
        return ventas.stream().mapToLong(Venta::getId).max().orElse(0) + 1;
    }
}
