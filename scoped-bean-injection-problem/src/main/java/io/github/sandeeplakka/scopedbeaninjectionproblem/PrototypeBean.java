package io.github.sandeeplakka.scopedbeaninjectionproblem;

import java.util.Random;

public class PrototypeBean {

    private int value;

    public PrototypeBean() {
        this.value = new Random().nextInt();
    }

    public int getValue() {
        return value;
    }
}
