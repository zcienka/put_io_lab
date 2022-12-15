package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        ExpenseRepository expenseRepository = new ExpenseRepository(new MyDatabase());
        expenseRepository.loadExpenses();
        assertEquals(0, expenseRepository.getExpenses().size());
    }

    @Test
    void loadExpensesMyDatabase() {
        ExpenseRepository expenseRepository = new ExpenseRepository(new MyDatabase());
        expenseRepository.loadExpenses();
        assertEquals(0, expenseRepository.getExpenses().size());
    }

    @Test
    void testLoadExpenses() {
        IFancyDatabase mockedDatabase = mock(IFancyDatabase.class);
        when(mockedDatabase.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository expenseRepository = new ExpenseRepository(mockedDatabase);
        expenseRepository.loadExpenses();
        InOrder inOrder = inOrder(mockedDatabase);
        inOrder.verify(mockedDatabase).connect();
        inOrder.verify(mockedDatabase).queryAll();
        inOrder.verify(mockedDatabase).close();

        assertEquals(0, expenseRepository.getExpenses().size());
    }

    @Test
    void testSaveExpenses() {
        IFancyDatabase mockedDatabase = mock(IFancyDatabase.class);
        when(mockedDatabase.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository expenseRepository = new ExpenseRepository(mockedDatabase);

        for (int i = 0; i < 5; i++) {
            expenseRepository.addExpense(new Expense());
        }
        expenseRepository.saveExpenses();

        InOrder inOrder = inOrder(mockedDatabase);
        inOrder.verify(mockedDatabase).connect();
        inOrder.verify(mockedDatabase).close();

        verify(mockedDatabase, times(5)).persist(any(Expense.class));

        assertEquals(5, expenseRepository.getExpenses().size());
    }
}
