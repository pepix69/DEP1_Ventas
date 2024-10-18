package com.upiiz.dep1.models;
import java.time.LocalDateTime;


public class Venta {
    private Long id;
    private LocalDateTime fechaVenta;
    private int idCliente;
    private double totalVenta;

    // Constructor, getters y setters
    public Venta(){}
    public Venta(Long id, LocalDateTime fechaVenta, int idCliente, double totalVenta) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.idCliente = idCliente;
        this.totalVenta = totalVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
