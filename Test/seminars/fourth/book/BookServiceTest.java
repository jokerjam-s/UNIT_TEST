package seminars.fourth.book;

import org.assertj.core.api.ObjectArrayAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookServiceTest {
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp(){
        book1 = new Book("1", "Book1", "Author1");
        book2 = new Book("2", "Book2", "Author2");
    }

    @Test
    void testBookServiceNotBook2(){
        InMemoryBookRepository bookRepository = mock(InMemoryBookRepository.class);
        BookService bookService = new BookService(bookRepository);

        when(bookRepository.findById("1")).thenReturn(book1);
        when(bookRepository.findById("2")).thenReturn(book2);

        String bookResult = bookService.findBookById("1").getId();

        verify(bookRepository, times(1)).findById("1");
        assertThat(bookResult).isNotEqualTo("2");
    }

    @Test
    void testBookServiceBook2(){
        InMemoryBookRepository bookRepository = mock(InMemoryBookRepository.class);
        BookService bookService = new BookService(bookRepository);

        when(bookRepository.findById("1")).thenReturn(book1);
        when(bookRepository.findById("2")).thenReturn(book2);

        String bookResult = bookService.findBookById("2").getId();

        verify(bookRepository, times(1)).findById("2");
        assertThat(bookResult).isEqualTo("2");
    }

    @Test
    void testBookServiceList(){
        List<Book> books = new ArrayList<>(){{ add(book1); add(book2);}};

        InMemoryBookRepository bookRepository = mock(InMemoryBookRepository.class);
        BookService bookService = new BookService(bookRepository);

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> bookResult = bookService.findAllBooks();

        verify(bookRepository, times(1)).findAll();
        assertIterableEquals(bookResult, books);
    }
}
