import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();
        int opcion = 0;

        while (opcion != 8) {
            System.out.println("********************************\n" +
                    "* Bienvenidos al conversor de monedas *\n" +
                    "********************************\n" +
                    "Ingresa la conversion que deseas realizar:\n" +
                    "1. Dólar a Peso Argentino\n" +
                    "2. Peso Argentino a Dólar\n" +
                    "3. Dólar a Real Brasileño\n" +
                    "4. Real Brasileño a Dólar\n" +
                    "5. Dólar a Peso Colombiano\n" +
                    "6. Peso Colombiano a Dólar\n" +
                    "7. Convertir otra moneda\n" +
                    "8. Salir");
            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1:
                    ConvertirMoneda.convertir("USD", "ARS", consulta, lectura);
                    break;
                case 2:
                    ConvertirMoneda.convertir("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", consulta, lectura);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", consulta, lectura);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "COP", consulta, lectura);
                    break;
                case 6:
                    ConvertirMoneda.convertir("COP", "USD", consulta, lectura);
                    break;
                case 7:
                    ConvertirMoneda.convertirOtraMoneda(consulta, lectura);
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}

