
temp_res = []
with open("/home/fbossiere/Dropbox/algorithms/google_jam/BribeThePrisoners/C-small-practice.in") as input_file:
    for i, line in enumerate(input_file):
	if i==0:
	    n = int(line)
	else:
	    temp_res.append([int(val) for val in line.split(" ")])

cases = []
for k, val in enumerate(temp_res):
    if k%2 == 0:
	cells = val[0]
    else:
	prisoners = val
	cases.append((1 + int(k/2), cells, prisoners))

# la liste "cases" est formee de tuples "case" dont le premier element est le numero du cas a traiter,
# le second est le nombre de cellules dans la prison, et le troisieme est la liste des prisoniers
# a liberer.

def solve(case):
    n_cells = case[1]
    prisoners = case[2]
    #########################
    # repondre ici
    #########################
    pass


output_path = "/home/fbossiere/Dropbox/algorithms/google_jam/BribeThePrisoners/C-small-practice.out"
with open(output_path, mode='w') as output:
    for case in cases:
        answer = solve_by_brute_force(case)
        output.write("Case #{i}: ".format(i=case[0]) + str(answer) + '\n')




############################################################################
# POUR VOUS AIDER

# def get_permutations(list_):
#     permutations = []
#     if len(list_) == 1:
#         return [list_]
#     for i in range(len(list_)):
#         for permutation in get_permutations(list_[:i] + list_[i+1:]):
#             permutations.append([list_[i]] + permutation)
#     return permutations

