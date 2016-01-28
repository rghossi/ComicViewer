package edu.rosehulman.rodrigr1.comicviewer;

import java.util.Random;

/**
 * Created by Matt Boutell on 12/21/2015.
 * Rose-Hulman Institute of Technology.
 * Covered by MIT license.
 */
public class Utils {

    private static Random sRandom = new Random(23); // TODO: Remove the seed when going to production.
    private static int[] sCleanIssues = {
            1558, // Roombas. (120)
            1557, // Recursion. (230)
            1553, // Public key (crypto)
            1543, // Gut bacteria.
            1542, // scheduling conflict (for algorithms)
            1537, // Types (304? 403?)
            1516, // Win by induction (230)
            1513, // Code quality (120-220-230)
            1508, // Operating systems
            1503, // Squirrel plan
            1185, // Ineffective sorts.
            1187, // Aspect ratio
            1033, // Honk iff you love Formal logic
            1095, // Fractal cultures
            1090, // Context-free grammars
            1016, // Valentine Prisoners Dilemna
            1014, // ImgRec: "What's wrong with this picture?"
            1007, // Sustainable
            1002, // Game AIs
            1000, // 1000 vs. 1024
            993, // Brand identity (generics...go Aldi!)
            990, // Plastic bags and waste!
            986, // Drinking fountain loops
            982, // Set theory
            974, // Generalizing "pass the salt"
            953, // My grade is in binary 11
            917, // Hostadler, Meta
            908, // The cloud ... and roombas
            878, // Recursion with train layouts
            859, // Unmatched parentheses
            844, // "Good" code or fast code?
            835, // Christmas "trees" and "heaps" of presents
            761, // depth-first search
            720, // genetic algorithms for gross food recipes
            678, // Researcher translation (research --> product)
            571, // Rollover on 32-bit computers - counting sheep
            541, // Parenthesizing emoticons!
            538, // Does 4096-bit encryption matter?
            518, // Flowcharts in flowchart form!
            506, // Roombas and "Theft of the Magi"
            505, // Theory of Comp: Turing completeness
            468, // Theory of Comp: Godel fetishes
            435, // Mathematicians
            424, // Security holes
            413, // Python + Robotics
            399, // Traveling salesman problem
            395, // Dead pixels in sky
            387, // Von Neumann machines
            381, // Mobius battle
            379, // Linked lists and "forgetting"
            378, // Real programmers use emacs, butterfly effect
            376, // pre-1970 bug
            371, // segfaults!
            370, // Redwall and crypto
            365, // slides and SIGGRAPH
            364, // Sign public key
            356, // Nerd sniping
            353, // Intro to Python
            350, // Virus aquarium
            340, // Boot sector
            331, // Photoshop
            329, // Turing Test
            327, // Databases
            303, // Compiling
            297, // Lisp
            292, // Goto
            287, // NPCompleteness (restaurant orders)
            278, // Linux vs Windows
            257, // Navajo code-talkers (crypto)
            256, //
            245, // Floor tile pattern walker
            244, // Recursion in gaming
            242, // Scientists
            234, // Escape artists (shell scripts)
            230, // Graph theory
            224, // Lisp
            221, // Random number
            217, // E^pi - pi
            210, // Markov chains and flowcharts
            208, // RegEx superhero
            205, // Turing machines
            192, // Working for Google
            184, // Rotational matrices
            177, // Alice and Bob
            173, // Movies and graph theory
            163, // 0 vs 1-based indices and Knuth
            156, // Comment gestures in IDEs
            149, // Sudo says (OS)
            138, // Pointers
            85, // Paths and calculus(good intro to XKCD)
            74, // Binary sudoku
            26, // Fourier transforms
            1119, // Undoing: Windmills connected to fans
            1106, // Add, like GTD
            1105, // License plate
            1103, // "9 button" on the microwave
            1097, // Hypocondriacs nightmare
            1052, // Every major's terrible.
            1040, // Lakes and oceans (need hi-res to make out detail!)***
            1035, // Cadbury eggs and sugar
            948, // state of AI research
            949, // File transfer
            951, // Gas prices and frugality!
            711, // Lie detector
            612, // Windows estimation of file copy time
            605, // Extrapolating (marriages and babies)
            597, // Internet addiction
            594, // Uterus hertz
            585, // Scientific outreach
            562, // Parallelogram = rectangle, Parking
            489, // Hired by Google maps
            485, // small items on a log scale
            482, // space height on a log scale
            431, // Baby delivery
            417, // The man who fell sideways
            389, // Marching Band
            320, // 28-hour day
            309, // Shopping teams
            284, // Tape measure
            273, // Electromagnetic spectrum
            272, // Linux again
            263, // Math teachers have universal truth
            253, // Highway engineer pranks!
            249, // Chess roller coaster
            247, // Factoring the time
            227, // Resistors
            195, // Internet map
            189, // D&D Exercise
            183, // Nerd moms
            140, // Nachos and cheese cycle
            131, // Fans
            125, // Marketing
            100, // Family circus and OCD
            69, // Bellman-Ford talk (not really funny)
            27, // Meat cereals (Jeff and Dana)
            21, // Kepler
            18, // Snapple (chemistry)
            16, // End of Monty Python
    };

    public static int getRandomCleanIssue() {
        int index = sRandom.nextInt(sCleanIssues.length);
        return sCleanIssues[index];
    }

}


