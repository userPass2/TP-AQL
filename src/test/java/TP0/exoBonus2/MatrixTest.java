package TP0.exoBonus2;

import TP0.exoBonus2.Matrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    private Matrix matrix1;
    private Matrix matrix2;
    private Matrix matrix3;

    @BeforeEach
    void setUp() {
        // Initialisation des matrices de test
        matrix1 = new Matrix(2);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(1, 0, 3);
        matrix1.set(1, 1, 4);

        matrix2 = new Matrix(2);
        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(1, 0, 7);
        matrix2.set(1, 1, 8);

        matrix3 = new Matrix(3); // Matrice de taille différente
        matrix3.set(0, 0, 1);
        matrix3.set(0, 1, 2);
        matrix3.set(0, 2, 3);
        matrix3.set(1, 0, 4);
        matrix3.set(1, 1, 5);
        matrix3.set(1, 2, 6);
        matrix3.set(2, 0, 7);
        matrix3.set(2, 1, 8);
        matrix3.set(2, 2, 9);
    }

    // Tests du constructeur
    @Test
    void testConstructorWithValidSize() {
        Matrix matrix = new Matrix(3);
        assertEquals(0, matrix.get(0, 0)); // Vérifie que la matrice est initialisée à 0
    }

    @Test
    void testConstructorWithZeroSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Matrix(0);
        });
    }

    @Test
    void testConstructorWithNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Matrix(-1);
        });
    }

    // Tests de la méthode set
    @Test
    void testSetWithValidValues() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 0, 1);
        assertEquals(1, matrix.get(0, 0));
    }

    @Test
    void testSetWithInvalidIndices() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix1.set(-1, 0, 1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix1.set(0, -1, 1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix1.set(2, 0, 1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix1.set(0, 2, 1);
        });
    }

    // Tests de la méthode get
    @Test
    void testGetWithValidIndices() {
        assertEquals(1, matrix1.get(0, 0));
        assertEquals(4, matrix1.get(1, 1));
    }

    @Test
    void testGetWithInvalidIndices() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix1.get(-1, 0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix1.get(0, -1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix1.get(2, 0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix1.get(0, 2);
        });
    }

    // Tests de la méthode add
    @Test
    void testAddWithCompatibleMatrices() {
        Matrix result = new Matrix(2);
        result.set(0, 0, 1);
        result.set(0, 1, 2);
        result.set(1, 0, 3);
        result.set(1, 1, 4);
        result.add(matrix2);
        assertEquals(6, result.get(0, 0));
        assertEquals(8, result.get(0, 1));
        assertEquals(10, result.get(1, 0));
        assertEquals(12, result.get(1, 1));
    }

    @Test
    void testAddWithIncompatibleMatrices() {
        assertThrows(IllegalArgumentException.class, () -> {
            matrix1.add(matrix3);
        });
    }

    @Test
    void testAddWithNullMatrix() {
        assertThrows(NullPointerException.class, () -> {
            matrix1.add(null);
        });
    }

    // Tests de la méthode multiply
    @Test
    void testMultiplyWithCompatibleMatrices() {
        Matrix result = new Matrix(2);
        result.set(0, 0, 1);
        result.set(0, 1, 2);
        result.set(1, 0, 3);
        result.set(1, 1, 4);
        result.multiply(matrix2);
        assertEquals(19, result.get(0, 0));
        assertEquals(22, result.get(0, 1));
        assertEquals(43, result.get(1, 0));
        assertEquals(50, result.get(1, 1));
    }

    @Test
    void testMultiplyWithIncompatibleMatrices() {
        assertThrows(IllegalArgumentException.class, () -> {
            matrix1.multiply(matrix3);
        });
    }

    @Test
    void testMultiplyWithNullMatrix() {
        assertThrows(NullPointerException.class, () -> {
            matrix1.multiply(null);
        });
    }

    // Tests de la méthode transpose
    @Test
    void testTranspose() {
        Matrix result = new Matrix(2);
        result.set(0, 0, 1);
        result.set(0, 1, 2);
        result.set(1, 0, 3);
        result.set(1, 1, 4);
        result.transpose();
        assertEquals(1, result.get(0, 0));
        assertEquals(3, result.get(0, 1));
        assertEquals(2, result.get(1, 0));
        assertEquals(4, result.get(1, 1));
    }

    // Tests de la méthode toString
    @Test
    void testToString() {
        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, matrix1.toString());
    }

    // Tests des cas limites
    @Test
    void testLargeMatrix() {
        Matrix largeMatrix = new Matrix(100);
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                largeMatrix.set(i, j, 1);
            }
        }
        assertEquals(1, largeMatrix.get(0, 0));
        assertEquals(1, largeMatrix.get(99, 99));
    }

    @Test
    void testMatrixWithZeroElements() {
        Matrix zeroMatrix = new Matrix(2);
        assertEquals(0, zeroMatrix.get(0, 0));
        assertEquals(0, zeroMatrix.get(0, 1));
        assertEquals(0, zeroMatrix.get(1, 0));
        assertEquals(0, zeroMatrix.get(1, 1));
    }

    // Tests de précision des calculs
    @Test
    void testPrecisionOfCalculations() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);
        
        Matrix result = new Matrix(2);
        result.set(0, 0, 1);
        result.set(0, 1, 2);
        result.set(1, 0, 3);
        result.set(1, 1, 4);
        result.multiply(matrix);
        
        assertEquals(7, result.get(0, 0));
        assertEquals(10, result.get(0, 1));
        assertEquals(15, result.get(1, 0));
        assertEquals(22, result.get(1, 1));
    }
}