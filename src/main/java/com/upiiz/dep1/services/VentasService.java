package com.upiiz.dep1.services;

import com.upiiz.dep1.repository.VentasRepository;
import com.upiiz.dep1.models.Venta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasService {
    // Requiero inyectar al servicio

    // Requerimos repositorio(Datos - Listado) - Venta
    VentasRepository ventasRepository;
    // Constructor

    public VentasService (VentasRepository VentasRepository) {
        this.ventasRepository = VentasRepository;
    }

    // Get - Todas las ventas
    public List<Venta> getAllVentas(){
        return ventasRepository.obtenerVentas();
    }

    // Get - Venta por id
    public Optional<Venta> getVentaById(Long id){
        return ventasRepository.obtenerVenta(id);
    }

    // Post - Crear venta
    public Venta createVenta(Venta venta){
        return ventasRepository.guardar(venta);
    }

    // Put - Actualizar venta
    public Venta updateVenta(Long id, Venta nuevaVenta){
        return ventasRepository.actualizar(id, nuevaVenta);
    }

    // Delete - Eliminar venta
    public void deleteVenta(Long id){
        ventasRepository.eliminar(id);
    }


}
