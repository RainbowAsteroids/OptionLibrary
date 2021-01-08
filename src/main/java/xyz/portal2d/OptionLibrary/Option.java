package xyz.portal2d.OptionLibrary;

import java.util.Collection;
import java.util.HashMap;

public abstract class Option {
    private final int id;
    private final String label;

    protected Option(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public abstract Option prompt();

    protected static Option prompt(Collection<Option> instances) {
        HashMap<Integer,Option> options = new HashMap<>();

        for ( Option o : instances ) {
            options.put(o.getId(), o);
            System.out.printf("%d. %s\n", o.getId(), o.getLabel());
        }

        int choice;
        while (true) {
            choice = IntegerPrompt.integerPrompt("Select an option: ").intValue();
            if (!options.containsKey(choice)) {
                System.out.println("That choice doesn't exist!");
            } else { break; }
        }

        return options.get(choice);
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return id == option.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

//public enum Option {
//    HELLO    (1, "Say Hello"),
//    CONVERSE (2, "Start a conversation"),
//    BYE      (3, "Say Goodbye"),
//    QUIT     (0, "Quit");
//
//    private final int id;
//    private final String label;
//
//    Option(int id, String label) {
//        this.id = id;
//        this.label = label;
//    }
//
//    public static Option prompt() {
//        HashMap<Integer,Option> options = new HashMap<>();
//
//        for( Option o : Option.values() ) {
//            options.put(o.getId(), o);
//            System.out.printf("%d. %s\n", o.getId(), o.getLabel());
//        }
//
//        int choice;
//        while (true) {
//            choice = IntegerPrompt.integerPrompt("Select an option: ").intValue();
//            if (!options.containsKey(choice)) {
//                System.out.println("That choice doesn't exist!");
//            } else { break; }
//        }
//
//        return options.get(choice);
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getLabel() {
//        return label;
//    }
//}
