package xyz.portal2d.OptionLibrary;

import java.util.ArrayList;

public class ExecutingOptionExample {
    public static void main(String[] args) {
        while (CommunicationOption.loop) {
            System.out.println();
            CommunicationOption.HELLO.executingPrompt();
        }
    }

    static class CommunicationOption extends ExecutingOption {
        public static boolean loop = true;

        private static final ArrayList<Option> instances = new ArrayList<>();

        public static final CommunicationOption HELLO    = new CommunicationOption(1,
                "Say hello", () -> { System.out.println("Hello, world!"); });
        public static final CommunicationOption CONVERSE = new CommunicationOption(2, "Start conversation", () -> {
            ExecutingOption option;
            while (ConversationOption.loop) {
                System.out.println();
                ConversationOption.HOW.executingPrompt();
            }
            ConversationOption.loop = true;
        });
        public static final CommunicationOption BYE      = new CommunicationOption(3,
                "Say goodbye", () -> { System.out.println("Goodbye, world!"); });
        public static final CommunicationOption QUIT     = new CommunicationOption(0,
                "Quit", () -> { loop = false; });

        private CommunicationOption(int id, String label, Runnable action) {
            super(id, label, action);
            instances.add(this);
        }

        @Override
        public Option prompt() {
            return prompt(instances);
        }
    }

    static class ConversationOption extends ExecutingOption {
        public static boolean loop = true;

        private static final ArrayList<Option> instances = new ArrayList<>();

        public static final ConversationOption HOW   = new ConversationOption(1,
                "Ask 'How are you?'", () -> { System.out.println("How are you?"); });
        public static final ConversationOption WHAT  = new ConversationOption(2,
                "Ask 'What are you doing?'", () -> { System.out.println("What are you doing?"); });
        public static final ConversationOption WHERE = new ConversationOption(3,
                "Ask 'Where are you?'", () -> { System.out.println("Where are you?"); });
        public static final ConversationOption QUIT  = new ConversationOption(0,
                "End conversation", () -> { loop = false; });

        private ConversationOption(int id, String label, Runnable action) {
            super(id, label, action);
            instances.add(this);
        }

        @Override
        public Option prompt() {
            return prompt(instances);
        }
    }
}
