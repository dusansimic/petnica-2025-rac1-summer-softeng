import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature);
}

interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        System.out.println("WeatherStation: new temperature = " + temperature);
        notifyObservers();
    }
}

class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("PhoneDisplay: Temperature updated to " + temperature + "°C");
    }
}

class WindowDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("WindowDisplay: New temperature is " + temperature + "°C");
    }
}

public class WeatherObserverPattern {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Observer phone = new PhoneDisplay();
        Observer window = new WindowDisplay();

        station.addObserver(phone);
        station.addObserver(window);

        station.setTemperature(25.5f);
        station.setTemperature(30.0f);
    }
}
