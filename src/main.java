import java.util.Collections;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);

        System.out.println("Digite o limite do seu cartão:");
        double limite = dados.nextDouble();
        dados.nextLine();

        CartaoCredito cartao = new CartaoCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite a descrição da compra:");
            String descricao = dados.next();


            System.out.println("Qual o valor da compra?");
            double preco = dados.nextDouble();


            Compra compra = new Compra(descricao, preco);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada! Obrigado por utilizar o manuCard 😉");
                System.out.println("Digite 1 para continuar ou 0 para sair");
                sair = dados.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }



        System.out.println("*******************************");
        System.out.println("Compras Realizadas: \n");

        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
                System.out.println(c.getDescricao() + " - R$" + c.getValor());
            }
        System.out.println("\n*******************************");


        System.out.println("\nSaldo do cartão: R$" + cartao.getSaldo());



    }
}
