String[] menuName = {"아메리카노", "카페라떼", "바닐라라떼"};
int[] menuPrice = {4000, 5000, 6000};

final int ERROR = -9;
final String ERR001 = "ERR001 : 다시 입력하세요.";
final String ERR002 = "ERR002 : 사이즈를 다시 입력하세요.";

int getPrice(int menu)
{
    if(menu <= -1 || menu >= menuPrice.length)
        return ERROR;

    return menuPrice[menu];
}

int getSizePrice(int size)
{
    if(size <= 0 || size >= 4)
        return ERROR;

    int price = 0;

    switch(size)
    {
        case 1: // 톨
            return 0;
        case 2: // 그란데
            return 500;
        case 3: // 벤티
            return 1000;
        default:
            return ERROR;
    }
}

int calculateTotal(int price, int sizePrice, int quantity)
{
    return ( price + sizePrice ) * quantity;
}

void printReceipt(int menuChoice, int menuSize, int quantity, int total)
{
    String sizeName = "";
    switch(menuSize)
    {
        case 1:
            sizeName = "톨";
            break;
        case 2:
            sizeName = "그란데";
            break;
        case 3:
            sizeName = "벤티";
            break;
        default:
            System.out.println(ERR002);
            return;
    }

    System.out.println("메뉴 : " + menuName[menuChoice]);
    System.out.println("크기 : " + sizeName);
    System.out.println("수량 : " + quantity);
    System.out.println("결제금액 : " + total);
}

void main()
{
    int menuChoice = 2; // 카페라떼
    int menuSize = 2; // 1: 톨 | 2: 그란데 | 3: 벤티
    int quantity = 3;

    int choicePrice = getPrice(menuChoice);
    if(choicePrice == ERROR)
    {
        System.out.println(ERR001);
        return;
    }

    int sizePrice = getSizePrice(menuSize);
    if(sizePrice == ERROR)
    {
        System.out.println(ERR002);
        return;
    }

    int totalPrice = calculateTotal(choicePrice, sizePrice, quantity);
    printReceipt(menuChoice, menuSize, quantity, totalPrice);
}