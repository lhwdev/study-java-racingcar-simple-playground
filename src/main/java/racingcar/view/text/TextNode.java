package racingcar.view.text;

import java.util.List;


public sealed interface TextNode {

    non-sealed interface Leaf extends TextNode {

        List<String> lines();

    }

    non-sealed interface Sections extends TextNode {

        List<TextNode> content();

    }

}
