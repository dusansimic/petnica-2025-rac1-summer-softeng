interface Button {
    void render();

    void onClick();
}

class HtmlButton implements Button {

    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    public void onClick() {
        System.out.println("HTML button clicked!");
    }
}

class WindowsButton implements Button {
    public void render() {
        System.out.println("button {\n  text: \"Test Button\"\n}");
        onClick();
    }

    public void onClick() {
        System.out.println("Windows button clicked!");
    }
}

abstract class Dialog {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}

class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}

class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

public class ButtonFactoryPattern {
    public static void main(String[] args) {
        String platform = "web";

        Dialog dialog;

        if (platform.equals("windows")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }

        dialog.renderWindow();
    }
}
