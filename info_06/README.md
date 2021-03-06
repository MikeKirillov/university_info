Подключение логирования к проекту, настройка логгера, совмещение разных типов логирования, оптимизация логируемой информации
Каждая система должна иметь логи о различных событиях, происходящих в программе, чтобы программист мог быстро найти и определить неисправность программы. Однако логов не должно быть слишком много или слишком мало, нужно эмпирическим путём узнать, какое количество окажется оптимальным. В этой части работы мы посмотрим на то, как организовать логирование самыми простыми инструментами в Java, как настроить его и как это выглядит.

В рамках всего проекта подключение логирования даст нам возможность выявлять исключительные ситуации, которые произошли у того или иного пользователя, чтобы мы могли анализировать залогированную информацию, находить и исправлять программные ошибки.

➡ В ходе работы потребуется:

работа с файлами ресурсов;
использование пакета java.util.logging;
обработка исключений.
⭐ В этом уроке необходимо выполнить следующее:

Удалить все вызовы System.out.println() в проекте.
Подумать, какие классы/методы стоит логировать, а какие нет. Необходимо логировать достаточное, но не слишком избыточное количество информации. Например, как считаете, нужно ли логировать выбор компаратора в switch?
Также в методе main() можно удалить код, относящийся к работе с JSON и его проверкам. В следующем уроке нам снова понадобится работа с  JSON, но сейчас лишний тестовый код не требуется. Оставить нужно только чтение XLSX-файла, сортировку, сбор и запись статистики.
Расставить логгеры в тех классах, которые вы решили залогировать. Имя логгеру рекомендуется задать по имени класса (например, MainClass.class.getName(); будет достаточно информативным).
Залогировать в методах всё, что вы считаете необходимым, используя разные уровни логирования (например, INFO, WARN, SEVERE). Также залогируйте обработку исключений, например, при чтении/записи Excel-файлов может возникать исключение IOException. Помните про то, что лишняя избыточность не нужна.
Запустить программу, убедиться, что логирование работает и выводит в консоль информацию.
В пакет ресурсов добавить новый ресурс, описывающий параметры для логгера. Назвать его logging.properties.
Настроить в этом файле логирование таким образом, чтобы логи одновременно писались в консоль и в файл. Для консольного вывода достаточно указать уровень логирования и простое форматирование. Для файловых логов нужно указать, как минимум, уровень логирования, паттерн названий файлов, флаг продолжения записи файла (чтобы ваши логи не перетирались каждый раз), установить произвольный лимит на количество файлов логов и на их объём, выбрать форматирование в XML-вид.
В методе main() настроить логгер с использованием этого конфигурационного файла.
Запустить программу, убедиться, что логи теперь пишутся и в консоль в простом формате, и в файл в формате XML.
В конце данной части работы должны получиться следующие результаты:

создан конфигурационный файл для настройки логирования;
убрана отладочная информация (вызовы System.out.println());
логгер настроен согласно конфигурационному файлу;
логи пишутся в консоль в простом формате и в файл в формате XML.
