
package pe.edu.pharmahelpdesk.dto;

public class TicketDTO {

    private String codigo;
    private String solicitante;
    private String puntoVenta;
    private String categoria;
    private String prioridad;
    private String descripcion;
    private String estado;

    public TicketDTO() {
    }

    public TicketDTO(
            String codigo,
            String solicitante,
            String puntoVenta,
            String categoria,
            String prioridad,
            String descripcion,
            String estado) {

        this.codigo = codigo;
        this.solicitante = solicitante;
        this.puntoVenta = puntoVenta;
        this.categoria = categoria;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(String puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
