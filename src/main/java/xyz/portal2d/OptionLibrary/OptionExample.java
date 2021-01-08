package xyz.portal2d.OptionLibrary;

import java.util.ArrayList;

public class OptionExample {
    public static void main(String[] args) {
        Option option;

        while (true) {
            option = CommunicationOption.HELLO.prompt();
            if (CommunicationOption.HELLO.equals(option)) {
                System.out.println("Hello, world!");
            } else if (CommunicationOption.CONVERSE.equals(option)) {
                System.out.println();
                while (true) {
                   option = ConversationOption.HOW.prompt();
                   if (ConversationOption.HOW.equals(option)) {
                       System.out.println("How are you?");
                   }
                   else if (ConversationOption.WHAT.equals(option)) {
                       System.out.println("What are you doing?");
                   }
                   else if (ConversationOption.WHERE.equals(option)) {
                       System.out.println("Where are you?");
                   }
                   else if (ConversationOption.QUIT.equals(option)) {
                       break;
                   }
                    System.out.println();
                }
            } else if (CommunicationOption.BYE.equals(option)) {
                System.out.println("Goodbye, world!");
            } else if (CommunicationOption.QUIT.equals(option)) {
                break;
            }
            System.out.println();
        }
    }

    static class CommunicationOption extends Option {
        private static final ArrayList<Option> instances = new ArrayList<>();

        public static final CommunicationOption HELLO    = new CommunicationOption(1, "Say hello");
        public static final CommunicationOption CONVERSE = new CommunicationOption(2, "Start conversation");
        public static final CommunicationOption BYE      = new CommunicationOption(3, "Say goodbye");
        public static final CommunicationOption QUIT     = new CommunicationOption(0, "Quit");

        private CommunicationOption(int id, String label) {
            super(id, label);
            instances.add(this);
        }

        @Override
        public Option prompt() {
            return prompt(instances);
        }
    }

    static class ConversationOption extends Option {
        private static final ArrayList<Option> instances = new ArrayList<>();

        public static final ConversationOption HOW   = new ConversationOption(1, "Ask 'How are you?'");
        public static final ConversationOption WHAT  = new ConversationOption(2, "Ask 'What are you doing?'");
        public static final ConversationOption WHERE = new ConversationOption(3, "Ask 'Where are you?'");
        public static final ConversationOption QUIT  = new ConversationOption(0, "End conversation");

        private ConversationOption(int id, String label) {
            super(id, label);
            instances.add(this);
        }

        @Override
        public Option prompt() {
            return prompt(instances);
        }
    }
}
