import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        // Conhecer e importar a classe Scanner
        Scanner scanner = new Scanner(System.in);
        
        String agencia = "";
        int numero = 0;
        String nomeCliente = "";
        double saldo = 0.0;
        
        //Exibir as mensagens para o usuário e obter os valores
        
        // Validação da Agência
        boolean agenciaValida = false;
        while (!agenciaValida) {
            System.out.println("Por favor, digite o número da Agência!");
            agencia = scanner.nextLine();
            
            if (agencia.trim().isEmpty()) {
                System.out.println("Erro: A agência não pode estar vazia. Tente novamente.");
            } else if (!agencia.matches("[0-9-]+")) {
                //Utiliza expressão regular para verificar se a agência contém apenas números e hífens
                System.out.println("Erro: A agência deve conter apenas números e hífens (-). Tente novamente.");
            } else {
                // Verifica se tem pelo menos 1 número
                boolean temNumero = agencia.matches(".*[0-9].*");
                
                // Conta quantos hífens tem
                long quantidadeHifens = agencia.chars().filter(ch -> ch == '-').count();
                
                // Verifica se começa com hífen
                boolean comecaComHifen = agencia.startsWith("-");
                
                if (!temNumero) {
                    System.out.println("Erro: A agência deve conter pelo menos um número. Tente novamente.");
                } else if (quantidadeHifens > 1) {
                    System.out.println("Erro: A agência deve conter no máximo um hífen (-). Tente novamente.");
                } else if (comecaComHifen) {
                    System.out.println("Erro: A agência não pode começar com hífen (-). Tente novamente.");
                } else {
                    agenciaValida = true;
                }
            }
        }

        // Validação do Número da Conta
        boolean numeroValido = false;
        while (!numeroValido) {
            System.out.println("Por favor, digite o número da Conta!");
            try {
                String numeroInput = scanner.nextLine();
                //Converte o valor digitado para um número inteiro
                numero = Integer.parseInt(numeroInput);
                if (numero <= 0) {
                    System.out.println("Erro: O número da conta deve ser um número positivo. Tente novamente.");
                } else {
                    numeroValido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite apenas números para a conta. Tente novamente.");
            }
        }

        // Validação do Nome do Cliente
        boolean nomeValido = false;
        while (!nomeValido) {
            System.out.println("Por favor, digite o seu nome!");
            //Lê a entrada do usuário e armazena na variável nomeCliente
            nomeCliente = scanner.nextLine();
            if (nomeCliente.trim().isEmpty()) {
                System.out.println("Erro: O nome não pode estar vazio. Tente novamente.");
            } else {
                nomeValido = true;
            }
        }

        // Validação do Saldo
        boolean saldoValido = false;
        while (!saldoValido) {
            System.out.println("Por favor, digite o seu saldo!");
            try {
                String saldoInput = scanner.nextLine();
                //Converte o valor digitado para um número double
                saldo = Double.parseDouble(saldoInput);
                if (saldo < 0) {
                    System.out.println("Erro: O saldo não pode ser negativo. Tente novamente.");
                } else {
                    saldoValido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um valor numérico válido para o saldo (ex: 237.48). Tente novamente.");
            }
        }

        //Exibir a mensagem final
        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.");

        scanner.close();
    }
}