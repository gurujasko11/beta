package App.model;

import java.util.ArrayList;
import java.util.List;

public class Basket{
    List<Position> positions;

    public Basket(){
        positions = new ArrayList<>();
    };

    public void addToBasket(Position pos) {
        positions.add(pos);
    }
    public void removeFromBasket(Position pos) {
        positions.remove(pos);
    }

    public List<Position> getPositions() {
        return positions;
    }
    public void clearBasket(){
        positions.clear();
    }
}
