# Math-Tex

Introduction:

math-tex is a rich text editor specially designed for blind and visually impaired. It will help them to write complex mathematical equations. It has inbuilt screen reader.

Implementation as of now, math-tex will have two input modes. math input mode and text input mode.

    Math input: from the text editor interface, this mode is activated by keyboard shortcut like m-m (alt + m).

    Text input: Our software will launch in this mode by default.

## Execution

espeak text to speech engine
 we'll use this open-source project. Our program will load with espeak by default. it will read every input from the user. And it will also follow along the users movements. here is the link for espeak project https://github.com/espeak-ng/espeak-ng

emacspeak 
math-tex will be very similar to emacspeak. check its documentation and complete project guideline here http://tvraman.github.io/emacspeak/blog/articles.html

Math Input we have to create different objects for following symbols

    fraction (/)

in line $\displaystyle \frac{a}{b}$ code

    Differential

in line $\displaystyle \frac{[differential]}{[differential] x}$ code

in line $\displaystyle \frac{[differential]^{n}y}{[differential] x^{n}}$ code

    Integral

in line $\displaystyle \int_{F(x)dx}$ code

in line $\displaystyle \int_{0}^{\pi F(x)dx}$ code

in line $\displaystyle \int_{0}^{2\pi F(x)dx}$ code

    some special symbols 

in line $\alpha$ code 
in line $\beta$ code 
in line $\gamma$ code 
in line $\delta$ code 
in line $\epsilon$ code 
in line $\theta\lambda$ code 
in line $\mu$ code

trigonometric functions and so many others.

    Remember we have to assign key binding for every symbol.

