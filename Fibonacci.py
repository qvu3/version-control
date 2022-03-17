
def f(n):
    if n < 0:
        print('Incorrect input')
    elif n == 0:
        return 0
    elif n == 1 or n == 2: 
        return 1
    else:
        return (f(n-1) + f(n-2))

def ff(n):
    a, b = 0, 1
    for i in range(0, n):
        a, b = b, a + b
    return a

print(f(30))

print(ff(30))