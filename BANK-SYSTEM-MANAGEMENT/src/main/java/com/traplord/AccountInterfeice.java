package com.traplord;

import java.io.Serializable;

public interface AccountInterfeice extends Serializable {
    void setBalance(double b);

    @Override
    String toString();

    int compareTo(Object o);
}
