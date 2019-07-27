public class Sun {

    // The sole instance of the class
    private static Sun onlyInstance;

    // Make the constructor private so its only accessible to
    // members of the class.
    private Sun() {
    }

    public void shine() {
        System.out.println("Sun is shining");
    }

    // Create a static method for object creation
    synchronized public static Sun getInstance() {

        if (onlyInstance == null) {
            // Only instantiate the object when needed.
            synchronized (Sun.class) {
                if (onlyInstance == null) {
                    onlyInstance = new Sun();
                }
            }
        }
        return onlyInstance;
    }
}

public class Planet {

    public void main() {
        Sun sun = Sun.getInstance();
        sun.shine();
    }
}