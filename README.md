# OptionLibrary
OptionLibrary is a simple Java 8 library for making CLIs. See `OptionExample.java` and `ExecutingOptionExample.java` for more examples on how to use this project.

```java
import java.util.ArrayList;

import xyz.portal2d.OptionLibrary.Option;

class ExampleOption extends Option {
    private static final ArrayList<Option> instances = new ArrayList<>(); // Track the instances of ExampleOption

    public static final ExampleOption ONE = new ExampleOption(1, "Option 1");
    public static final ExampleOption TWO = new ExampleOption(2, "Option 2");
    public static final ExampleOption THREE = new ExampleOption(3, "Option 3");
    public static final ExampleOption QUIT = new ExampleOption(0, "Quit"); // IDs can be out of order
    
    // Boilerplate code
    private ExampleOption(int id, String label) {
        super(id, label);
        instances.add(this);
    }

    // Boilerplate code
    @Override
    public Option prompt() {
        return prompt(instances);
    }

    public static void main(String[] args) {
        Option option;
        while (true) {
            System.out.println();
            option = ONE.prompt();
            if (QUIT.equals(option)) {
                break;
            } else {
                System.out.printf("You chose %s!\n", option.getLabel());
            }
        }
    }
}
```