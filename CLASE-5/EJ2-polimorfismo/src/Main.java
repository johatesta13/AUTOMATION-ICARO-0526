import java.util.List;

public class Main{


    void main() {

        List<Aplicacion> apps = List.of(new Instagram(), new WhatsApp(), new Gmail());

        for (Aplicacion app : apps){
             app.compartir();
        }
    }
}
