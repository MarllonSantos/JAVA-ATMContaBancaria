public class Conta {
    private int id;
    private String nome;
    private double ammount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public Conta(int id, String nome, double ammount) {
        this.id = id;
        this.nome = nome;
        this.ammount = ammount;
    }

    public void transferencia(Conta destino, double value) {
        if (this.ammount >= value) {
            this.ammount -= value; // Debita da conta de origem
            destino.setAmmount(destino.getAmmount() + value); // Credita na conta de destino
            System.out.println("Transferência realizada com sucesso!\n");
        } else {
            System.out.println("Você não tem saldo suficiente.\nDeposite dinheiro em sua conta.\n");
        }
    }

    public void deposito(double value){
        this.ammount = this.ammount + value;
        System.out.println("Deposito realizado com sucesso!\n");
    }

    public void consultaSaldo(){
        System.out.printf("Saldo disponível: %s\n\n", this.ammount);
    }

    public void consultaConta(){
        System.out.println("##########################################");
        System.out.println("#");
        System.out.println("#\tMarllonX Microservices ~*");
        System.out.println("#");
        System.out.printf("#\tConta: %s", this.id);
        System.out.printf("\n#\tNome: %s", this.nome);
        System.out.printf("\n#\tSaldo: %.2f\n", this.ammount);
        System.out.println("#");
        System.out.println("##########################################");
    }
}
