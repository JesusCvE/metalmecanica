package idat.edu.pe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    
    @Column(name = "tipoDoc")
    private String tipoDoc;
    
    @Column(name = "nroDoc")
    private String nroDoc;

    @Column(name = "userNom")
    private String userNom;

    @Column(name = "userApe")
    private String userApe;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "nacimiento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nacimiento;
    
    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "pass")
    private String pass;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String tipoDoc, String nroDoc, String userNom, String userApe, String sexo,
            Date nacimiento, String direccion, String telefono, String email, String pass) {
        this.idUsuario = idUsuario;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.userNom = userNom;
        this.userApe = userApe;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.pass = pass;
    }

    public Usuario(String tipoDoc, String nroDoc, String userNom, String userApe, String sexo, Date nacimiento,
            String direccion, String telefono, String email, String pass) {
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.userNom = userNom;
        this.userApe = userApe;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.pass = pass;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getUserNom() {
        return userNom;
    }

    public void setUserNom(String userNom) {
        this.userNom = userNom;
    }

    public String getUserApe() {
        return userApe;
    }

    public void setUserApe(String userApe) {
        this.userApe = userApe;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
    
}
