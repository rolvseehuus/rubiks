Rubiks Solver
=============

This is a quick stab at a rubics solver. I aim for it to maybe be usable
to find algorithms between states, but the main reason I built it was just
for fun (and to learn some Kotlin.)

The cube isn't necessarily layed out in the best way - I read about the
permutation group model for the cube after having built the core model of
this - so the data layout is bespoke. But it kinda works, and it allows
me to search the cube-space.

Valid colors for a cube is Y(ellow), B(lue), R(ed),
G(reeen), W(hite) and O(range).

Each face is a char-array with 9 cells numbered like this:

    0 1 2
    3 4 5
    6 7 8

Each face is then labelled (F)ront, (B)ack, (U)p, (D)own, (L)eft, (R)ight.

A rotation of the front-side will move colors on (2,5,8) of the left side
to 


For simplicity, I chose to use small letters for counter-clockwise
rotations, instead of using primes as is customary. So a sequence of rotations
become a sequence of strings where each letter is an individual rotation:

    RUr

Cubers will recognize that move as one they've done a million times.

The solutions are not adapted to efficient processing with the hends. The 
solver only uses single-face rotations of the sides, so instead of
rotating the cube around the y-axis and turn the right face clockwise, the
solver will just turn the front face for example.

Building and installing
-----------------------


Usage
-----

In order to use it, you need to input a cube. The input format is six lines of
letters denoting one configuration per face, listed in this order:

    Up
    Front
    Back
    Right
    Left
    Down

This is as already mentioned perhaps not indentical to other solvers - I 
might add some more format options later.

    $ cube --solve input.txt --view 10 

This will try to solve the cube defined in 'input.txt', and it will emit
the current state for the cube every 10th turn. Break the solver at any
time by <ctrl>-c





