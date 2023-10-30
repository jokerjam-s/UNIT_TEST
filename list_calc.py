"""
Модуль калькулятора средних значений списков.
"""


class AvgList:
    """
    Калькулятор средних значений.
    """

    def __init__(self):
        """
        Инициализация класса двумя списками
        """
        self._list_1 = []
        self._list_2 = []

    def get_first(self) -> str:
        """
        Строковое представление первого списка.
        :return: Строка значений списка
        """
        return str(self._list_1)

    def get_second(self) -> str:
        """
        Строковое представление второго списка.
        :return: Строка значений списка
        """
        return str(self._list_2)

    def add_first(self, list1: list[int | float]):
        """
        Дополнение первого списка значениями.
        :param list1: Список добавляемых значений
        :return: None
        """
        self._list_1.extend(list1)

    def add_second(self, list2: list[int | float]):
        """
        Дополнение второго списка значениями.
        :param list2: Список добавляемых значений
        :return: None
        """
        self._list_2.extend(list2)

    @property
    def avg_first(self) -> float:
        """
        Расчет среднего значения по списку 1.
        :return: Среднее значение или None, если список пуст или содержит неверные данные
        """
        try:
            result = sum(self._list_1) / len(self._list_1)
        except (TypeError, ZeroDivisionError):
            result = None
        return result

    @property
    def avg_second(self) -> float:
        """
        Расчет среднего значения по списку 2.
        :return: Среднее значение или None, если список пуст или содержит неверные данные
        """
        try:
            result = sum(self._list_2) / len(self._list_2)
        except (TypeError,  ZeroDivisionError):
            result = None
        return result

    @property
    def compare_avg(self) -> str:
        """
        Сравнение средних значений списков.
        :return: Результат сравнения
        """
        result = "Средние значения равны"

        if self.avg_first is None or self.avg_second is None:
            result = "Неверные данные"
        elif self.avg_first < self.avg_second:
            result = "Второй список имеет большее среднее значение"
        elif self.avg_first > self.avg_second:
            result = "Первый список имеет большее среднее значение"

        return result
