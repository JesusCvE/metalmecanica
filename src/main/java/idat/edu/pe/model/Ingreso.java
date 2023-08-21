package idat.edu.pe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ingresoalmacen")
public class Ingreso implements Serializable {
    
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIngreAlm")
    private Integer idIngreAlm;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @Column(name = "precioTotal")
    private String precioTotal;

    @Column(name = "igv")
    private String igv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    public Ingreso() {
    }

    public Ingreso(Integer idIngreAlm, Date fecha, String precioTotal, String igv, Proveedor proveedor,
            Empleado empleado) {
        this.idIngreAlm = idIngreAlm;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.igv = igv;
        this.proveedor = proveedor;
        this.empleado = empleado;
    }

    public Ingreso(Date fecha, String precioTotal, String igv, Proveedor proveedor, Empleado empleado) {
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.igv = igv;
        this.proveedor = proveedor;
        this.empleado = empleado;
    }

    public Integer getIdIngreAlm() {
        return idIngreAlm;
    }

    public void setIdIngreAlm(Integer idIngreAlm) {
        this.idIngreAlm = idIngreAlm;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getIgv() {
        return igv;
    }

    public void setIgv(String igv) {
        this.igv = igv;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
