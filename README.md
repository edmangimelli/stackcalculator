# stackcalculator

A Simple stack calculator.

| command | description |
|---|---|
| _number_ | push number onto stack |
| **+** | top-number-of-stack  +  second-to-top-number-of-stack |
| **-** | top-number-of-stack  -  second-to-top-number-of-stack |
| __*__ | top-number-of-stack  *  second-to-top-number-of-stack |
| **/** | top-number-of-stack  /  second-to-top-number-of-stack |
| **%** | top-number-of-stack  %  second-to-top-number-of-stack |
| **^** | top-number-of-stack  ^  second-to-top-number-of-stack |
| **!** | factorial of top-number-of-stack (implemented using only the other stack commands listed above and below) |
| **d** | duplicate the top-number-of-stack |
| **c** | clear stack |
| **q** | quit |

### Example Session

```
> 1 2 3 4 5

  5
  4
  3
  2
  1

> +

  9
  3
  2
  1

> +

  12
  2
  1

> 3 *

  36
  2
  1

> /

  18
  1

> d

  18
  18
  1

> *

  324
  1

> /

  324

> 9 !

  362880
  324

> /

  1120

> -1 * 1120 +

  0
```
