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
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "venta")
@XmlRootElement
public class Venta implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Integer idVenta;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @Column(name = "documento")
    private String documento;

    @Column(name = "importeTotal")
    private Double importeTotal;

    @Column(name = "tipoComprobante")
    private String tipoComprobante;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "razonsocial")
    private String razonSocial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    public Venta() {
    }

    public Venta(Integer idVenta, Date fecha, String documento, Double importeTotal, String tipoComprobante, String ruc,
            String razonSocial, Empleado empleado) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.documento = documento;
        this.importeTotal = importeTotal;
        this.tipoComprobante = tipoComprobante;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.empleado = empleado;
    }

    public Venta(Date fecha, String documento, Double importeTotal, String tipoComprobante, String ruc,
            String razonSocial, Empleado empleado) {
        this.fecha = fecha;
        this.documento = documento;
        this.importeTotal = importeTotal;
        this.tipoComprobante = tipoComprobante;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.empleado = empleado;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
}
