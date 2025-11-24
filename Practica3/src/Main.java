
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Capacidad del montículo: ");
        int capacidad = Integer.parseInt(br.readLine());

        MinHeap montMinimo = new MinHeap(capacidad);

        montMinimo.menu();
    }
}

