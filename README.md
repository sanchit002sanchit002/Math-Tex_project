# Math-Tex

**Introduction:**

math-tex is a rich text editor specially designed for blind and visually impaired. It will help them to write complex mathematical equations. It has inbuilt screen reader.

**Implementation:**

as of now, math-tex will have two input modes. math input mode and text input mode.

1.    Math input: 
from the text editor interface, this mode is activated by keyboard shortcut like m-m (alt + m).

2.    Text input: 
Our software will launch in this mode by default.

## Execution

*  espeak text to speech engine

we'll use this open-source project. Our program will load with espeak by default. it will read every input from the user. And it will also follow along the users movements. here is the link for espeak project <https://github.com/espeak-ng/espeak-ng>

*  emacspeak 

math-tex will be very similar to emacspeak. check its documentation and complete project guideline here <http://tvraman.github.io/emacspeak/blog/articles.html>
and emacspeak for windows <https://github.com/SaqibS/emacspeak-on-windows>

*  Math Input 

we have to create different objects for following symbols


Keybord shortcut | mathematical symbol | latex command
-----------------|---------------------|--------------
    m-m-         |  wait for 1 more key|    -
    m-m-f       |  fraction symbol    |  $\frac{}$  
    m-m-d       |  d  (delta)         |  $|diff
    m-m-i       |  integral symbol    |  \int


>    fraction (/)

$\displaystyle \frac{a}{b}$ 

let's say, after pressing m-m-f (alt + m + f) software will print fraction symbol  and TTS will speak fraction. Then focus will automatically  move to numerator and TTS says"numerator" where user will have option to input "a" value. Similarly after pressing enter or right arrow key focus will now move to denominator and TTS will say "denominator" and again user have option to input value of "b".  
After one more "Enter key" it will move out of this fraction.

>    Differential

Software will use m-m-d (alt + m + d) this will print "d" or "debba" on screen and TTS output.

$\displaystyle \frac{[differential] y}{[differential] x}$

In this case, user should press m-m-f (alt + m + f) for initial fraction, then should press m-m-d (alt + m + d). Once both symbols spoken out, then he should enter value for "y".

$\displaystyle \frac{[differential]^{n}y}{[differential] x^{n}}$

To move focus on superscript (power) user should press m-up arrow (alt + ↑) 

>    Integral

Software will use m-m-i (alt + m + i) key to print "integral" symbol and TTS will speak out.
To move focus on subscript (base) user should press m-down arrow (alt +↓)  
$\displaystyle \int_{F(x)dx}$

$\displaystyle \int_{0}^{\pi F(x)dx}$

$\displaystyle \int_{0}^{2\pi F(x)dx}$

>    some special symbols 

$\alpha$

$\beta$

$\gamma$

$\delta$

$\epsilon$

$\theta\lambda$

$\mu$

trigonometric functions and so many other functions.

**Remember we have to assign key binding for every symbol.**

