---
author: Nikolay Kureychik
weight: 1
---

# Analysis of winning strategies in the game "Pebbles"

## Task condition

Consider the following game. Given **one** pile containing `n` stones. Two players take turns making moves. In one turn, the player can remove 1, 2 or 3 stones from the pile **. The player who takes the last stone wins.

## Theoretical analysis

### Basic concepts of combinatorial game theory

Let's introduce a formal classification of positions:

- **P-position** (losing position) - a position from which there is no winning strategy with optimal opponent play
- **N-position** (winning position) - a position from which there is a winning strategy

**Fundamental properties of P- and N-positions:**
1. The terminal position (0 stones) is a P-position
2. There is at least one move from the N-position to the P-position.
3. From the P-position, all moves lead to the N-position

### Formal statement of the problem

Define the winning function `W: ℕ → {True, False}`:
- `W(n) = False` if a position with n stones is a losing one (P-position)
- `W(n) = True` if a position with n stones is a winning one (N-position)

Recurrence relation for arbitrary n ≥ 1:
W(n) = W(n-1) ∨ W(n-2) ∨ W(n-3)

** The main theorem.** For a game with many possible moves S = {1, 2, 3}, a position with n stones is a losing (P-position) if and only if n ≡ 0 (mod 4).

### Proof of the theorem

**The proof** will be carried out by the method of complete mathematical induction.

**Base of induction:**
By direct verification, we set:
- `W(0) = False` and 0 ≡ 0 (mod 4)
- `W(1) = True` and 1 ≢ 0 (mod 4)
- `W(2) = True` and 2 ≢ 0 (mod 4)
- `W(3) = True` and 3 ≢ 0 (mod 4)

**The assumption of induction:** For all k < m it holds:
W(k) = True ⇔ k ≢ 0 (mod 4)
W(k) = False ⇔ k ≡ 0 (mod 4)

**The induction step:** Consider n = m.

**Case 1: m ≡ 0 (mod 4)**
Let m = 4k, k ≥ 1. Transitions are possible from this position:
- In 4k - 1 ≡ 3 (mod 4)
- In 4k - 2 ≡ 2 (mod 4)
- In 4k - 3 ≡ 1 (mod 4)

By the assumption of induction, all these positions are N-positions. Therefore, from position m, all moves lead to N-positions, which by definition makes m a P-position.

**Case 2: m ≡ r (mod 4), where r ∈ {1, 2, 3}**
From position m, the player can remove exactly r stones by moving to position m - r ≡ 0 (mod 4). By the assumption of induction, this position is a P-position. So there is a move from an N-position to a P-position, which proves that m is an N-position.

The induction transition is completed, the theorem is proved.

## Algorithmic analysis

### Computational model

The graph of the game can be represented as a directed acyclic graph G =(V, E), where:
- V = {0, 1, 2, ..., n} is the set of vertices (positions)
- E = {(i, j) | i - j ∈ {1, 2, 3} and i > j} is the set of edges (moves)

The winning positions are determined by the method of reverse induction, starting from the terminal vertex 0.

### Optimal algorithm

For an arbitrary position n ∈ ℕ:
is_winning(n) = (n mod 4 ≠ 0)
winning_move(n) = n mod 4 (if n mod 4 ≠ 0)
**Computational complexity:** O(1) time, O(1) memory.

## Theoretical generalizations

### General subtraction game

The game under consideration is a special case of the **subtraction game** (subtraction game).

**Definition.** A subtractive game with a set of subtraction S ⊆ ℕ\{0} is defined by:
- Position: n ∈ ℕ
- Valid moves: n → n - s for s ∈ S, s ≤ n
- The player who cannot make a move loses

** The general theorem.** For the subtractive game with S = {1, 2, ..., k}:
- P-positions: n ≡ 0 (mod k+1)
- N-positions: n ≢ 0 (mod k+1)

**The proof** is similar to the proof for k = 3.

### Invariant strategy

The key idea of the analysis is to find the **invariant** that holds for optimal play. In this case, the invariant is the property of "leaving the opponent a position multiple of 4".

### Symmetrical strategy

This game allows for a symmetrical strategy: the second player can always respond with a move such that the sum of both players' moves is 4.

## Connection with other combinatorial games

### Him with one bunch

The considered game is equivalent to a Nim with one pile and a limit on the maximum number of stones taken. In classic Nim, without restrictions, the first move can take the entire pile, so all positions n > 0 are winning.

### Games with impartial rules

The game belongs to the class of **imperialist games** - games where the set of acceptable moves depends only on the current position, and not on which player is moving.

## Conclusion

The game "Pebbles" is a canonical example of a deterministic game with complete information, demonstrating the fundamental principles of combinatorial game theory. The simplicity of characterization of winning positions makes it an ideal object for studying methods of combinatorial game analysis, including the invariant method, symmetric strategies, and the theory of P- and N-positions.

The results obtained are of practical importance in the development of game algorithms, artificial intelligence and the theory of computational complexity of games.