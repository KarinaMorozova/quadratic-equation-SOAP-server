package com.example.producingwebservice;

import example.Roots;
import org.springframework.stereotype.Component;

@Component
public class CoeffsRepository {

    public Roots findRoots(int a, int b, int c) {
        Roots result = new Roots();
        double discriminant = b * b - 4 * a * c;

        result.setD(discriminant);

        if (discriminant < 0) {
            result.setFormula("The equation has no real roots");
        }
        else if (discriminant == 0) {
            result.setFormula(a + "x^2 + " + b + "x + " + c);
            double x = -b / 2 * a;
            result.setX1(x);
        }
        else {
            result.setFormula(a + "x^2 + " + b + "x + " + c);
            double x1 = (-b + Math.sqrt(discriminant))/(2.0 * a);
            double x2 = (-b - Math.sqrt(discriminant))/(2.0 * a);
            result.setX1(x1);
            result.setX2(x2);
        }
        return result;
    }
}
