package racingcar.controller.console;


import java.util.List;
import racingcar.view.text.TextNode;


public class ConsoleTextNodePrinter {

    public void print(TextNode node) {
        if (node instanceof TextNode.Leaf leaf) {
            print(leaf);
        } else if (node instanceof TextNode.Sections sections) {
            print(sections);
        }
    }


    public void print(TextNode.Leaf node) {
        for (String line : node.lines()) {
            System.out.println(line);
        }
    }

    public void print(TextNode.Sections node) {
        List<TextNode> content = node.content();
        for (TextNode section : content) {
            System.out.println();
            print(section);
        }
    }

}
