/**
 * Weather class file for threads example.
 * @author Josh Gregory (Apr. 2025)
 */

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class Weather implements Runnable {
    public void run() {
        try {
            while (true) {
                // create new URL obj
                URL url = new URL("https://api.weather.gov/stations/KRYY/observations/latest");

                // pass url to scanner stream
                Scanner scanner = new Scanner(url.openStream());

                // to read JSON returned from url
                String lines = "";
                while (scanner.hasNextLine()) {
                    lines += scanner.nextLine();
                }
            }
        } catch (IOException ex) {

        }
    }
}
