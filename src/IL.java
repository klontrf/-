import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class IL implements ItemListener {
    ItemEvent e;
    @Override
    public void itemStateChanged(ItemEvent e) {
        this.e=e;
    }
}
