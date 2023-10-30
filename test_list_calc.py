"""
Тестирование калькулятора средних значений.
"""
import pytest
from list_calc import AvgList


def test_add_first_list():
    avg_list = AvgList()

    avg_list.add_first([2, 3, 4, 5])
    avg_list.add_first([6, 7])

    assert avg_list.get_first() == "[2, 3, 4, 5, 6, 7]"


def test_add_second_list():
    avg_list = AvgList()

    avg_list.add_first([7, 2, -2, 4])
    avg_list.add_first([8, 3])

    assert avg_list.get_first() == "[7, 2, -2, 4, 8, 3]"


def test_calc_first_avg_right_data():
    avg_list = AvgList()

    avg_list.add_first([4, 5, 8, 7])
    assert avg_list.avg_first == 6


def test_calc_first_avg_wrong_data():
    avg_list = AvgList()

    avg_list.add_first([4, 5, 8, '7'])
    assert avg_list.avg_first is None


def test_calc_second_avg_rigt_data():
    avg_list = AvgList()

    avg_list.add_second([2, 3, 4, 5])
    assert avg_list.avg_second == 3.5


def test_calc_second_avg_wring_data():
    avg_list = AvgList()

    avg_list.add_second([2, None, 4, 5])
    assert avg_list.avg_second is None


@pytest.mark.parametrize("list1, list2, result",
                         [([1, 2, 3, 4], [1, 2, 3], "Первый список имеет большее среднее значение"),
                          ([1, 2, 3], [1, 2, 3, 4], "Второй список имеет большее среднее значение"),
                          ([1, 2, 3], [1, 2, 3], "Средние значения равны"),
                          ([1, 2, '3'], [1, 2, 3], "Неверные данные"),
                          ([1, 2, 3], [1, 2, '3'], "Неверные данные"),
                          ([1, 2, '3'], [1, 2, '3'], "Неверные данные"),
                          ([1, 2, 3], [], "Неверные данные"),
                          ([], [1, 2, 3], "Неверные данные"),
                          ([], [], "Неверные данные"),
                          ])
def test_compare_avg_data(list1, list2, result):
    avg_list = AvgList()
    avg_list.add_first(list1)
    avg_list.add_second(list2)

    assert avg_list.compare_avg == result


if __name__ == '__main__':
    pytest.main(["-v"])
