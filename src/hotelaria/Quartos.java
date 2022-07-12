package hotelaria;


public class Quartos {
    
    private Integer id;
    private String tipo;
    private String ocupados;
    private String n_camas;
    private String valor;
    private Estadia estadia;
    private Cliente cliente;
    private Reserva reserva;

    public Quartos() {
        estadia = new Estadia();
        cliente = new Cliente();
        reserva = new Reserva();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOcupados() {
        return ocupados;
    }

    public void setOcupados(String ocupados) {
        this.ocupados = ocupados;
    }

    public String getN_camas() {
        return n_camas;
    }

    public void setN_camas(String n_camas) {
        this.n_camas = n_camas;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
        
    
}
