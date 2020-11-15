from itertools import zip_longest, islice


def to_int_keys_best(l):
    seen = set()
    ls = []
    for e in l:
        if not e in seen:
            ls.append(e)
            seen.add(e)
    ls.sort()
    index = {v: i for i, v in enumerate(ls)}
    return [index[v] for v in l]


def suffix_array_best(s):
    n = len(s)
    k = 1
    line = to_int_keys_best(s)
    while max(line) < n - 1:
        line = to_int_keys_best(
            [a * (n + 1) + b + 1
             for (a, b) in
             zip_longest(line, islice(line, k, None),
                         fillvalue=-1)])
        k <<= 1
    return line


def lcp_array(s, sa):
    n = len(s)
    k = 0
    lcp = [0] * n
    rank = [0] * n
    for i in range(n):
        rank[sa[i]] = i

    for i in range(n):
        if rank[i] == n - 1:
            k = 0
            continue
        j = sa[rank[i] + 1]
        while i + k < n and j + k < n and s[i + k] == s[j + k]:
            k += 1
        lcp[rank[i]] = k;
        if k:
            k -= 1

    return lcp


def inverse_array(l):
    n = len(l)
    ans = [0] * n
    for i in range(n):
        ans[l[i]] = i
    return ans


if __name__ == '__main__':
    L = input()
    inverse_suffix_array = suffix_array_best(L)


    suffix_array = inverse_array(inverse_suffix_array)
    
    for item in suffix_array:
        print(item + 1, end=' ')
    LCP = lcp_array(L, suffix_array)
    LCP.pop()
    LCP.insert(0, 'x')
    print()
    for item in LCP:
        print(item, end=' ')

