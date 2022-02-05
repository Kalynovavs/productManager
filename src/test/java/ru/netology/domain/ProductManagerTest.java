package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductManager manager = new ProductManager();
    private  Book first = new Book(1, "Бладшот", 120, "Онегин");
    private  Book second = new Book(2, "Вперед", 300, "Пушкин");
    private  Book third = new Book(3, "Отель", 5500, "Онегин");
    private  Smartphone fourth = new Smartphone(4, "Galaxy1", 1000, "Nokia");
    private  Smartphone fifth =  new Smartphone(5, "Galaxy12", 5000, "samsung");
    private  Smartphone sixth =  new Smartphone(6, "alpha100", 10000, "Nokia");
    private  Smartphone seventh = new Smartphone(7, "ЭВУ500", 15000, "ЗАО Полёт");
    private  Book eighth = new Book(8, "Полёт", 250, "Лермонтов");
    private  Book nineth = new Book(9, "Водный мир", 700, "Толстой");
    private  Smartphone tenth = new Smartphone(10, "z3", 9500, "motorola");
    private  Smartphone eleventh = new Smartphone(11, "xperia", 8500, "sony");
    private  Other uncnown = new Other();


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(nineth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(uncnown);
    }

    @Test
    public void shouldFindProductByAutor() {
        Product[] actual = manager.searchBy("Пушкин");
        Product[] expected = new Product[]{
                second
        };
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindProductByName() {
        Product[] actual = manager.searchBy("Бладшот");
        Product[] expected = new Product[]{
                first
        };
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindProductByManufacturer() {
        Product[] actual = manager.searchBy("sony");
        Product[] expected = new Product[]{
                eleventh
        };
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldNotFindProduct() {
        Product[] actual = manager.searchBy("Ничего");
        Product[] expected = new Product[0];
        assertArrayEquals(actual, expected);
    }


    @Test
    public void shouldFindFewProducts() {
        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = new Product[]{
                fourth,
                fifth
        };
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindFewDifferentProducts() {
        Product[] actual = manager.searchBy("Полёт");
        Product[] expected = new Product[]{
                seventh,
                eighth
        };
        assertArrayEquals(actual, expected);
    }
}