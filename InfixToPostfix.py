class CharStack:
    def __init__(self, size):
        self.data = [''] * size
        self.top = -1

    def push(self, c):
        self.top += 1
        self.data[self.top] = c

    def pop(self):
        val = self.data[self.top]
        self.top -= 1
        return val

    def peek(self):
        return self.data[self.top]

    def isEmpty(self):
        return self.top == -1


class IntStack:
    def __init__(self, size):
        self.data = [0] * size
        self.top = -1

    def push(self, x):
        self.top += 1
        self.data[self.top] = x

    def pop(self):
        val = self.data[self.top]
        self.top -= 1
        return val

    def isEmpty(self):
        return self.top == -1


def prec(c):
    if c == '^':
        return 3
    elif c == '/' or c == '*':
        return 2
    elif c == '+' or c == '-':
        return 1
    else:
        return -1


def isRightAssociative(c):
    return c == '^'


def infixToPostfix(s):
    st = CharStack(len(s))
    res = []

    i = 0
    while i < len(s):
        c = s[i]

        if c.isdigit():

            while i < len(s) and s[i].isdigit():
                res.append(s[i])
                i += 1

            res.append(' ')
            i -= 1

        elif c == '(':
            st.push('(')

        elif c == ')':
            while not st.isEmpty() and st.peek() != '(':
                res.append(st.pop())
            st.pop()

        else:
            while (not st.isEmpty() and st.peek() != '(' and
                   (prec(st.peek()) > prec(c) or
                   (prec(st.peek()) == prec(c) and not isRightAssociative(c)))):
                res.append(st.pop())
            st.push(c)

        i += 1

    while not st.isEmpty():
        res.append(st.pop())

    return ''.join(res)


def floorDiv(a, b):
    if a * b < 0 and a % b != 0:
        return (a // b) - 1
    return a // b


def evaluatePostfix(postfix):
    st = IntStack(len(postfix))

    i = 0
    while i < len(postfix):

        token = postfix[i]

        if token == ' ':
            i += 1
            continue

        if token.isdigit():

            num = 0

            while i < len(postfix) and postfix[i].isdigit():
                num = num * 10 + (ord(postfix[i]) - ord('0'))
                i += 1

            st.push(num)
            i -= 1

        else:
            val1 = st.pop()
            val2 = st.pop()

            result = 0

            if token == '+':
                result = val2 + val1
            elif token == '-':
                result = val2 - val1
            elif token == '*':
                result = val2 * val1
            elif token == '/':
                result = val2 // val1
            elif token == '^':
                result = int(val2 ** val1)

            print(val2, token, val1, "=", result)

            st.push(result)

        i += 1

    return st.pop()


# main program
exp = input("Masukkan ekspresi: ")
exp = exp.replace(" ", "")

postfix = infixToPostfix(exp)

print()
print("Postfix:", postfix)
print()

hasil = evaluatePostfix(postfix)

print()
print("Hasil akhir=", hasil)