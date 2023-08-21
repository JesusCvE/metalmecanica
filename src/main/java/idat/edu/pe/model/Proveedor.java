package idat.edu.pe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "proveedor")
@XmlRootElement
public class Proveedor implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @Column(name = "tipoDoc")
    private String tipoDoc;
    
    @Column(name = "nroDoc")
    private String nroDoc;

    @Column(name = "razSocial")
    private String razSocial;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor, String tipoDoc, String nroDoc, String razSocial, String direccion,
            String telefono, String email) {
        this.idProveedor = idProveedor;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.razSocial = razSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Proveedor(String tipoDoc, String nroDoc, String razSocial, String direccion, String telefono, String email) {
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.razSocial = razSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getRazSocial() {
        return razSocial;
    }

    public void setRazSocial(String razSocial) {
        this.razSocial = razSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
