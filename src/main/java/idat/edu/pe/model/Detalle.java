package idat.edu.pe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallealmacen")
public class Detalle implements Serializable {
    
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetaAlma")
    private Integer idDetaAlma;

    @Column(name = "preCompra")
    private String preCompra;

    @Column(name = "preVenta")
    private String preVenta;

    @Column(name = "stockActu")
    private String stockActu;

    @Column(name = "stockTotal")
    private String stockTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idIngreAlm")
    private Ingreso ingreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public Detalle() {
    }

    public Detalle(Integer idDetaAlma, String preCompra, String preVenta, String stockActu, String stockTotal,
            Ingreso ingreso, Producto producto) {
        this.idDetaAlma = idDetaAlma;
        this.preCompra = preCompra;
        this.preVenta = preVenta;
        this.stockActu = stockActu;
        this.stockTotal = stockTotal;
        this.ingreso = ingreso;
        this.producto = producto;
    }

    public Detalle(String preCompra, String preVenta, String stockActu, String stockTotal, Ingreso ingreso,
            Producto producto) {
        this.preCompra = preCompra;
        this.preVenta = preVenta;
        this.stockActu = stockActu;
        this.stockTotal = stockTotal;
        this.ingreso = ingreso;
        this.producto = producto;
    }

    public Integer getIdDetaAlma() {
        return idDetaAlma;
    }

    public void setIdDetaAlma(Integer idDetaAlma) {
        this.idDetaAlma = idDetaAlma;
    }

    public String getPreCompra() {
        return preCompra;
    }

    public void setPreCompra(String preCompra) {
        this.preCompra = preCompra;
    }

    public String getPreVenta() {
        return preVenta;
    }

    public void setPreVenta(String preVenta) {
        this.preVenta = preVenta;
    }

    public String getStockActu() {
        return stockActu;
    }

    public void setStockActu(String stockActu) {
        this.stockActu = stockActu;
    }

    public String getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(String stockTotal) {
        this.stockTotal = stockTotal;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    

}
